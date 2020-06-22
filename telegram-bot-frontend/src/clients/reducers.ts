import {Client} from "./model";
import {CLIENTS_ACTION_CONSTANTS} from "./constants";

export interface ClientsState {
    clients: Client[],
    currentClient: Partial<Client>
}

const initialState: ClientsState = {
    clients: [],
    currentClient: {}
};

interface SetClientsAction {
    type: 'SET_CLIENTS'
    payload: Client[]
}

interface SetCurrentClientAction {
    type: 'SET_CURRENT_CLIENT'
    payload: Client
}

export type ClientActionTypes = SetClientsAction | SetCurrentClientAction

export function clientsReducer(
    state = initialState,
    action: ClientActionTypes
): ClientsState {
    switch (action.type) {
        case CLIENTS_ACTION_CONSTANTS.SET_CLIENTS:
            return {
                ...state,
                clients: action.payload
            };
        default:
            return state
    }
}
