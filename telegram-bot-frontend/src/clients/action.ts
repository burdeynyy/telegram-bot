import {ClientActionTypes} from "./reducers";
import {Client} from "./model";
import {CLIENTS_ACTION_CONSTANTS} from "./constants";

export function setClients(clients: Client[]): ClientActionTypes {
    return {
        type: CLIENTS_ACTION_CONSTANTS.SET_CLIENTS,
        payload: clients
    }
}