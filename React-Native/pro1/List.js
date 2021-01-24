import React, {Component} from 'react'
import {Text, View, TouchableOpacity, StyleSheet} from 'react-native'

class List extends Component {
    state = {
        names : [
            {id : 1, name : 'Navneet'},
            {id : 2, name : 'Ansul'},
            {id : 3, name : 'Manvendra'}
        ]
    }

    alertItemName = (item) => {
        alert(item.name)
    }

    render() {
        return (
            <View>
                {
                   this.state.names.map((item, index) => (
                  <TouchableOpacity
                     key = {item.id}
                     style = {styles.container}
                     onPress = {() => this.alertItemName(item)}>
                     <Text style = {styles.text}>
                        {item.name}
                     </Text>
                  </TouchableOpacity>
               ))
            }
            </View>
        )
    }
}

export default List;

const styles = StyleSheet.create({
    container : {
        padding : 10,
        marginTop : 3
    },
})