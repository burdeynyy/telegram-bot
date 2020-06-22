import React from 'react';
import ClientsComponent from "./clients";
import MessagesComponent from "./messages";
import './styles.scss'


const AppComponent: React.FC = () => {
    return (
        <div className="app-container">
            <div className="container">
                <div className="row">
                    <div className="col-lg-4">
                        <ClientsComponent/>
                    </div>
                    <div className="col-lg-8">
                        <MessagesComponent/>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default AppComponent;
