import React from 'react';
import './styles.scss'
import {useDispatch, useSelector} from "react-redux";
import {Client} from "./model";
import {setSelectedClient} from "../messages/action";
import {getSelectedClient} from "../messages/selectors";
import ClientComponent from "./components/client";
import {getClients} from "./selectors";
import {loadClients} from "./thunks";
import RefreshButton from "../common/refresh-button/refresh-button";


const ClientsComponent: React.FC = () => {
    let clients = useSelector(getClients);
    let selectedClient = useSelector(getSelectedClient);

    let dispatch = useDispatch();

    React.useEffect(() => {
        dispatch(loadClients());
    }, []);

    function handleClientOnClick(client: Client) {
        dispatch(setSelectedClient(client));
    }

    function refreshClientsHandler() {
        dispatch(loadClients());
    }

    return (
        <>
            <div className="clients">
                <div className="clients__header">
                    <div className="clients__title">
                        Contacts
                    </div>
                    <RefreshButton onClick={refreshClientsHandler}/>
                </div>
                <div className="clients__content">
                    {clients.map(client => (
                        <ClientComponent
                            onClick={handleClientOnClick}
                            value={client}
                            selected={selectedClient && client.id === selectedClient.id}
                        />
                    ))}
                </div>
            </div>
        </>
    );
};

export default ClientsComponent;
