import {Selector} from 'react-redux';
import {Client} from "./model";
import {AppStoreState} from "../common/store";

export const getClients: Selector<AppStoreState, Client[]> = (state) => {
    return state.clients.clients;
};
