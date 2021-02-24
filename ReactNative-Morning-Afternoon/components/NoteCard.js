import { StatusBar } from 'expo-status-bar';
import React, {useState, useEffect} from "react";
import {View, AsyncStorage, StyleSheet, TextInput} from "react-native";
import { Button, Card, Layout, Text } from '@ui-kitten/components';



const NoteCard = ({noteData, navigation}) => {
    const deleteCard = () => {
        navigation.navigate("NoteList", {para: {note: noteData, operation:"delete"}} );
    }

    const Header = (props) => (
        <View {...props} >
          <Text category='h6'>{noteData.title}</Text>
        </View>
    );
    
    const Footer = (props) => (
        <View {...props} style={styles.footerContainer}>
            <Button
            onPress = {deleteCard}
            style={styles.footerControl}
            size='small'
            appearance='outline'
            textStyle={{color:'red'}}>
            Delete
            </Button>
        </View>
    );

    return(
        <View>
            <Card style={styles.card} header={Header} footer={Footer}>
            <Text>{noteData.note}</Text>
            </Card>
        </View>
    );
};

const styles = StyleSheet.create({
    topContainer: {
      flexDirection: 'row',
      justifyContent: 'space-between',
    },
    card: {
      flex: 1,
      margin: 7
    },
    footerContainer: {
      flexDirection: 'row',
      justifyContent: 'flex-end',
      padding: 5
    },
    footerControl: {
      marginHorizontal: 2,
    },
  });

export default NoteCard;