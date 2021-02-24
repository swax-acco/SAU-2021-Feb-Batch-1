import React, {useState, useRef} from "react";
import {View, StyleSheet, TextInput} from "react-native";
import 'react-native-get-random-values';
import { v4 as uuid, v4 } from 'uuid';
import { Input, Button, Text } from '@ui-kitten/components';

export default function AddNote({navigation}) {
    var title = "", note = "";
    const createNote = () => {
        console.log(title);
        if(title === ' ' || title === '') return;
        let newNote = {id: v4(), title: title, note: note};
        navigation.navigate("NoteList",  {para: {note: newNote, operation:"add"}});
    }
    return(
        <View style={styles.container}>
            <Text style={{margin: 5}} category='h4'>Add Note</Text>
            <Input style={{marginTop:15}} onChangeText = {(text) => title = text} size='large' placeholder='Title' />
            <Input style={styles.input} multiline={true} onChangeText = {(text) => note = text} textStyle={{ minHeight: 100 }} placeholder='Note' />
            <View style={styles.buttonContainer}>
            <Button style={styles.button} onPress = {createNote} status='primary'>Add</Button>
            <Button style={styles.button} onPress = {() => {navigation.navigate("NoteList")}} appearance='outline' status='primary'>Cancel</Button>
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        margin:8,
        marginTop:35
    },
    button: {
        margin: 5,
        width:185
    },
    buttonContainer: {
        flexDirection:'row',
        flexWrap:'wrap'
    }
});