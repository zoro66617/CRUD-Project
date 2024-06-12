import React from 'react';
import Navbar from './layout/Navbar';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import AddUser from './pages/AddUser';
import EditUser from './pages/EditUser';

import Home from './pages/Home';
import Viewuser from './pages/Viewuser';
import Login from './pages/Login';



function App() {
    return (
        <div className="App">
            <Router>
                
                <Navbar />

                <Routes>
                <Route exact path='/' element={<Login />} />
                    <Route exact path='/home' element={<Home />} />
                    <Route exact path='/adduser' element={<AddUser />} />
                    <Route exact path='/edituser/:id' element={<EditUser />} />
                    <Route exact path='/viewuser/:id' element={<Viewuser />} />
                    
                </Routes>
            </Router>
        </div>
    );
}

export default App;
