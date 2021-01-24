import React from 'react';
import { StyleSheet, Text, View, TextInput, Button, FlatList, TouchableHighlight, Image} from 'react-native';
import List from '../List';

class HomeScreen extends React.Component {
    render() {
        return (
            <View className="browse">
                <View className = "top-nav page-title flex">
                    <Text></Text>
                    <Text></Text>
                    <Text></Text>
                        <View className = "search-bar" >
                            <TextInput className="search-input" type="text" placeholder="Search for movies" style = {styles.textInput}/>
                            <Button style = {styles.button} title = "Search"> </Button>
                            <Button title = "Cancel Search"> </Button>

                            <FlatList
                                data={[{ title: 'Title Text', key: 'item1' }]}
                                renderItem={({ item, index, separators }) => (
                                    <TouchableHighlight
                                    key={item.key}
                                    onPress={() => this._onPress(item)}
                                    onShowUnderlay={separators.highlight}
                                    onHideUnderlay={separators.unhighlight}>
                                    <View style={{ backgroundColor: 'white' }}>
                                        <View>
                                            <Image style={styles.tinyLogo} source={require('./img/3idiots.png')} />
                                            <Text>Title : 3-Idiots </Text>
                                            <Text>Year : 2010 </Text>
                                            <Button title = "ViewDetails" />
                                        </View>

                                        <View>
                                            <Image style={styles.tinyLogo} source={require('./img/bharat.jpg')} />
                                            <Text>Title : Bharat </Text>
                                            <Text>Year : 2019 </Text>
                                            <Button title = "ViewDetails" />
                                        </View>

                                        <View>
                                            <Image style={styles.tinyLogo} source={require('./img/robot.jpg')} />
                                            <Text>Title : Robot </Text>
                                            <Text>Year : 2015 </Text>
                                            <Button title = "ViewDetails" />
                                        </View>

                                        <View>
                                            <Image style={styles.tinyLogo} source={require('./img/tarjan.jpg')} />
                                            <Text>Title : Bharat </Text>
                                            <Text>Year : 2019 </Text>
                                            <Button title = "ViewDetails" />
                                        </View>

                                    </View>
                                    </TouchableHighlight>
                                )}
                                />
                        </View>
                </View>
            </View>
        )
    }
}

export default HomeScreen;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#4F6D7A',
      },
    textInput: {
        height : 40,
        width : 420,
        borderWidth: 1
    },     
    button: {
        width : 100,
        borderWidth: 2
    },
    tinyLogo: {
        width: 200,
        height: 200,
        alignContent: 'center'
    }
});

