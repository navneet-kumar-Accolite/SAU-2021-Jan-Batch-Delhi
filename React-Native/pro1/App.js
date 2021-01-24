import React, { Component } from 'react';
import {Platform,StyleSheet,Text,View,StatusBar, Image} from 'react-native';
import { NavigationContainer, createStackNavigator } from 'react-native';
import HomeScreen from './Home/HomeScreen.js'

export default class App extends Component {
  constructor(){  
    super();  
    this.state={  
    isVisible : true,  
   }  
 } 

  Hide_Splash_Screen=()=>{  
    this.setState({   
      isVisible : false
    });
  }  
  componentDidMount(){  
    var that = this;  
    setTimeout(function(){  
      that.Hide_Splash_Screen();  
    }, 5000);  
   }  

  render() {
    let Splash_Screen = (  
      <View style={styles.SplashScreen_RootView}>  
        <View style = {styles.SplashScreen_RootView} >
          <View style = {styles.SplashScreen_ChildView} >
          <Image source={{uri:'https://static.javatpoint.com/tutorial/react-native/images/react-native-tutorial.png'}} style={{width:'100%', height: '100%', resizeMode: 'contain'}} />  

          </View>
        </View>
      </View>)

      return(
        <View style = {styles.MainContainer}>
                { (this.state.isVisible === true) ? Splash_Screen : null }   
          <HomeScreen />
        </View>
      );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#4F6D7A',
  },
  welcome: {
    fontSize: 50,
    textAlign: 'center',
    margin: 10,
    color: 'rgb(144,144,200)',
    fontFamily : 'Cochin',
    fontWeight: 'bold'    
  },
  instructions: {
    textAlign: 'center',
    color: '#F5FCFF',
    marginBottom: 5,
  },
});