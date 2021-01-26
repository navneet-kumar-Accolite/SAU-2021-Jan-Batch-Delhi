
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Application {
	public static void main(String[] args) {

        ApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml");

        SetMap setmapObj = (SetMap) factory.getBean("setmap");
        setmapObj.display();		
	}

}
