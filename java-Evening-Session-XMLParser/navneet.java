import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

class Operation {
    static Document validDoc, invalidDoc, doc;
    static Element cData;
        
    private static Element fun(Element d, Element s){
        NamedNodeMap sa = s.getAttributes();
         for(int i=0; i< sa.getLength(); i++){
             d.setAttribute(sa.item(i).getNodeName(), sa.item(i).getNodeValue());
         }
         return d;
    }
    
    private static Element copy(Document doc, Element sl){
        Element dest = fun(doc.createElement(sl.getNodeName()),sl);
        NodeList loa = sl.getElementsByTagName("LOA");
        for(int i=0; i < loa.getLength();i++) {
            Element curr=(Element)loa.item(i);
            dest.appendChild(fun(doc.createElement(curr.getNodeName()),curr));
        }
        return dest;
    }
    private static List<Element> validInvalid(NodeList l1, Element validData, Element invalidData){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        Element validLic, invalidLic;
        
        for(int i=0; i<l1.getLength(); i++){
            Element pro = (Element)l1.item(i);
            Element validPro = validDoc.createElement("CSR_Producer"), invalidPro = invalidDoc.createElement("CSR_Producer") ;

            NamedNodeMap s1 = pro.getAttributes();
            for(int j = 0; j< s1.getLength(); j++)
            	validPro.setAttribute(s1.item(j).getNodeName(), s1.item(j).getNodeValue());

            NamedNodeMap s2 = pro.getAttributes();
            for(int j=0; j < s2.getLength(); j++){
                invalidPro.setAttribute(s2.item(i).getNodeName(), s2.item(i).getNodeValue());
            }
            NodeList listLic = pro.getElementsByTagName("License");
            for(int j = 0; j < listLic.getLength(); j++){
                Element cur =(Element) listLic.item(j);
                String expiryDate = cur.getAttribute("License_Expiration_Date");
                LocalDate licExpiryDate = LocalDate.parse(expiryDate,dateTimeFormatter);
                boolean valid = today.isBefore(licExpiryDate);
                if(valid){
                    validLic = copy(validDoc, cur);
                    validPro.appendChild(validLic);
                }
                else{
                    invalidLic = copy(invalidDoc, cur);
                    invalidPro.appendChild(invalidLic);
                }
            }
            validData.appendChild(validPro);
            invalidData.appendChild(invalidPro);
        }

        List<Element> data = new ArrayList<Element>();
        data.add(validData);
        data.add(invalidData);

        return data;
    }
    
    public static void validData(Document d1, Document d2) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
	        Element sHeader = (Element) d1.getElementsByTagName("CSR_Report_Header").item(0);

            validDoc = docBuilder.newDocument();
            Element csrReport1 = validDoc.createElement("CSR_Report");
            Element csrReportHeader1 = validDoc.createElement("CSR_Report_Header");
            csrReportHeader1 = fun(csrReportHeader1, sHeader);
            csrReport1.appendChild(csrReportHeader1);
            Element validData = validDoc.createElement("CSR_Report_Body");	        
	 
            invalidDoc = docBuilder.newDocument();
            Element csrReport2 = invalidDoc.createElement("CSR_Report");
            Element csrReportHeader2 = invalidDoc.createElement("CSR_Report_Header");
            csrReportHeader2 = fun(csrReportHeader2, sHeader);
            csrReport2.appendChild(csrReportHeader2);
            Element invalidData = invalidDoc.createElement("CSR_Report_Body");
            
            NodeList l1 = d1.getElementsByTagName("CSR_Producer");
            NodeList l2 = d2.getElementsByTagName("CSR_Producer");
		
            List<Element> data = validInvalid(l1 , validData, invalidData );
            validData = data.get(0);
            invalidData = data.get(1);

            data = validInvalid(l2 , validData, invalidData);
            validData = data.get(0);
            invalidData = data.get(1);            

            // appending in valid file
            csrReport1.appendChild(validData); 
            // appending in invalid file            
            csrReport2.appendChild(invalidData); 

            validDoc.appendChild(csrReport1);
            invalidDoc.appendChild(csrReport2);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            //writing to valid file
            DOMSource valid = new DOMSource(validDoc);
            StreamResult validStream = new StreamResult(new File("valid.xml"));
            transformer.transform(valid, validStream);

            //writing to invalid file
            DOMSource invalid = new DOMSource(invalidDoc);
            StreamResult invalidStream = new StreamResult(new File("invalid.xml"));
            transformer.transform(invalid, invalidStream);            
            
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		
		System.out.println("valid - Invalid separate file is created");
	}
    public static void merge(Document d1, Document d2){
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document doc;
            doc = documentBuilder.newDocument();
            Element csr_report = doc.createElement("CSR_Report");
            doc.appendChild(csr_report);
            Element csr_report_header = doc.createElement("CSR_Report_Header");

            Element sourceHeader = (Element) d1.getElementsByTagName("CSR_Report_Header").item(0);
            csr_report_header = fun(csr_report_header, sourceHeader);
            csr_report.appendChild(csr_report_header);

            cData = doc.createElement("CSR_Report_Body");
            csr_report.appendChild(cData);

            NodeList first = d1.getElementsByTagName("CSR_Producer");
            NodeList second = d2.getElementsByTagName("CSR_Producer");

            //----
            NodeList firstLic, secondLic;

            for (int i = 0; i < first.getLength(); i++) {

                Element firstElement = (Element) first.item(i);
                for (int j = 0; j < second.getLength(); j++) {

                    Element cisr_producer = doc.createElement("CISR_PRODUCER");

                    Element secondElement = (Element) second.item(j);
                    String firstNipr = (firstElement.getAttribute("NIPR_Number"));
                    String secondNipr = secondElement.getAttribute("NIPR_Number");

                    if (firstNipr.equals(secondNipr)) {
                        cisr_producer = fun(cisr_producer, firstElement);
                        firstLic = firstElement.getElementsByTagName("License");
                        secondLic = secondElement.getElementsByTagName("License");
                        cData.appendChild(cisr_producer);
                    }
                }
            }            
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(doc);
            StreamResult streamResult = new StreamResult(new File("merge.xml"));
            transformer.transform(domSource, streamResult);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Merging is Complete");
   }
}

public class navneet {
    public static void main(String[] args){
        try {
            File file1 = new File("file1.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document d1 = dBuilder.parse(file1);
            d1.getDocumentElement().normalize();

            File file2 = new File("file2.xml");
            DocumentBuilderFactory dbFactory2 = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder2 = dbFactory2.newDocumentBuilder();
            Document d2 = dBuilder2.parse(file2);
            d2.getDocumentElement().normalize();

            Operation.validData(d1, d1);

            Operation.merge(d1, d2);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Execution Finished: ");
    }
}
