import { StatusBar } from 'expo-status-bar';
import React from 'react';
import {createStackNavigator} from '@react-navigation/stack';
import {NavigationContainer} from '@react-navigation/native';
import * as eva from '@eva-design/eva';
import { ApplicationProvider, Layout, Text } from '@ui-kitten/components';

import Login from './components/Login';
import NoteList from './components/NoteList';
import AddNote from "./components/AddNote";

const Stack = createStackNavigator();

// const App = () => {
//   return (
//     <NavigationContainer>
//       <Stack.Navigator>
//         <Stack.Screen name = "Login" component = {Login}/>
//         <Stack.Screen name = "NoteList" component = {NoteList}/>
//         <Stack.Screen name = "AddNote" component = {AddNote}/>
//       </Stack.Navigator>
//     </NavigationContainer>
//   )
// }

const HomeScreen = () => (
  <Layout style={{flex: 1, justifyContent: 'center', alignItems: 'center'}}>
    <Text category='h1'>HOME</Text>
  </Layout>
);

export default () => (
  <ApplicationProvider {...eva} theme={eva.light}>
    {/* <HomeScreen /> */}
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name = "Login" component = {Login} options={{ headerShown: null }} />
        <Stack.Screen name = "NoteList" component = {NoteList} options={{ headerShown: null }} />
        <Stack.Screen name = "AddNote" component = {AddNote} options={{ headerShown: null }} />
      </Stack.Navigator>
    </NavigationContainer>
  </ApplicationProvider>
);

// export default App;
