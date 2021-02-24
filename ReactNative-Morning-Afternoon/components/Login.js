import React, {useState, useEffect, useRef} from "react";
import {View, StyleSheet, Image, AsyncStorage } from "react-native";
import { Input, Button, Text } from '@ui-kitten/components';
// import AsyncStorage from '@callstack/async-storage';

const Login = ({navigation}) => {
    const [userName, setUserName] = useState("");
    const input = useRef();
    useEffect(() => {
        AsyncStorage.getItem("userNameKey").then(name => {
            if(name){
                console.log(name);
                setUserName(name);
                // navigation.navigate("NoteList");
            }
        })
        
    }, []);

    useEffect(() => {
        AsyncStorage.setItem("userNameKey", userName);
    }, [userName]); 

    const logMe = () => {
        console.log(userName)
        if(!userName){
            return;
        }
        navigation.navigate("NoteList");
    };
    return(
        <View style = {styles.container}>
            <Image source={require('../assets/note-icon.png')} />
            <Text style={{color:'grey'}} category='h1'>Notes</Text>
            <Text style={{color:'#3366FF'}} category='h6'>User Login</Text>
            <Input style={styles.input} onChangeText = {(text => setUserName(text.trim()))} size='large' placeholder="User Name" value={userName}/>
            <Button style={styles.button} onPress = {logMe}>Login</Button>
        </View>
    );
}

export default Login;

const styles = StyleSheet.create({
    input: {
        width:200,
        margin: 5,
        marginTop: "20%"
    },
    container: {
        flex: 0,
        justifyContent: "center",
        alignItems: "center",
        marginTop: "30%"
    },
    button: {
        width: 200
    }
})