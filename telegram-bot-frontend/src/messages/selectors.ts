import {Selector} from 'react-redux';
import {Message} from "./model";
import {Client} from "../clients/model";
import {AppStoreState} from "../common/store";

export const getMessages: Selector<AppStoreState, Message[]> = (state) => {
    return state.messages.messages;
};

export const getSelectedClient: Selector<AppStoreState, Client | undefined> = ({messages: {selectedClient}}) =>
    selectedClient;

export const getCurrentText: Selector<AppStoreState, string> = ({messages: {currentText}}) =>
    currentText;

