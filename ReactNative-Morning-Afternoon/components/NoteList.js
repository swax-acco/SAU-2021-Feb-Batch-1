import { StatusBar } from 'expo-status-bar';
import React, {useState, useEffect} from "react";
import { View, StyleSheet, TextInput,ScrollView, AsyncStorage} from "react-native";
// import AsyncStorage from '@callstack/async-storage';
import { Input, Button, Text } from '@ui-kitten/components';
import NoteCard from './NoteCard';


const NoteList = ({navigation, route = null}) => {
    const [noteDataList, setNoteDataList] = useState([]);
    const [message, setMessage] = useState(<View></View>);
    const EmptyMessage = <View style = {styles.messageContainer}><Text style={styles.message} category='h6'>No Notes</Text></View>;
    useEffect(() => {
        AsyncStorage.getItem("dataListKey").then(dataList => {
            console.log(dataList);
            if(dataList){
                const storedData = JSON.parse(dataList);
                setNoteDataList(storedData);
            }
        })
       
    }, []);
    useEffect(() => {
        AsyncStorage.setItem("dataListKey", JSON.stringify(noteDataList));
        if(noteDataList.length > 0)
            setMessage(<View></View>);
        else
            setMessage(EmptyMessage);
    }, [noteDataList]);

    useEffect(() => {
        setNoteDataList(preList => {
            if(route.params){
                console.log(route.params.para);
                if(route.params.para.operation === "add")
                    return [...preList, route.params.para.note];
                if(route.params.para.operation === "delete")
                    return preList.filter(data => data.id != route.params.para.note.id);
            }
            else
                return preList;
        })
    }, [route.params])
    
    const AddNote = () => {
        navigation.navigate("AddNote");
    }
    return(
        <View style={styles.container}>
            <View style={styles.listContainer}>
            <Text style={{margin: 3}} category='h4'>My Notes</Text>
            <Button style={styles.button} size='small' onPress = {AddNote} status='primary'>Take Note</Button>
            </View>
            <ScrollView style={{minWidth:"100%"}}>
                {noteDataList.map(data => <NoteCard noteData = {data} key= {data.id} navigation = {navigation}/>)}
                {message}
            </ScrollView>
        </View>
    );
};

const styles = StyleSheet.create({
    input: {
        margin:5,
        marginTop: 40,
    },
    button: {
        margin: 10,
        width:100
    },
    messageContainer: {
        width: "100%",
        marginTop: "50%",
        justifyContent: "center",
        alignItems: "center"
    },
    container: {
        marginTop: 25,
        justifyContent: "flex-end"
    },
    listContainer: {
        flexDirection:'row',
        flexWrap:'wrap',
        justifyContent:"space-between",
        margin: 10,
        marginLeft: 15
    }

});
export default NoteList;