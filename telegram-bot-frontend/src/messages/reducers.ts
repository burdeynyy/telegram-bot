import {Message} from "./model";
import {MESSAGES_ACTION_CONSTANTS} from "./constants";
import {Client} from "../clients/model";

export interface MessagesState {
    messages: Message[];
    currentMessage: Partial<Message>;
    selectedClient?: Client;
    requestParams: RequestParams;
    currentText: string;
}

export interface RequestParams {
    page: number
}

const defaultRequestParams: RequestParams = {
    page: 0
};

const initialState: MessagesState = {
    selectedClient: undefined,
    messages: [],
    currentMessage: {},
    requestParams: defaultRequestParams,
    currentText: ''
};



interface SetMessagesAction {
    type: MESSAGES_ACTION_CONSTANTS.ADD_MESSAGES
    payload: Message[]
}

interface SetSelectedClient {
    type: MESSAGES_ACTION_CONSTANTS.SET_SELECTED_CLIENT
    payload: Client
}

interface ClearMessages {
    type: MESSAGES_ACTION_CONSTANTS.CLEAR_MESSAGES
    payload: null
}

interface SetRequestParams {
    type: MESSAGES_ACTION_CONSTANTS.SET_REQUEST_PARAMS
    payload: RequestParams
}

interface SetCurrentText {
    type: MESSAGES_ACTION_CONSTANTS.SET_CURRENT_TEXT
    payload: string
}

interface IncrementPage {
    type: MESSAGES_ACTION_CONSTANTS.INCREMENT_PAGE
    payload: null
}

interface ClearRequestParams {
    type: MESSAGES_ACTION_CONSTANTS.CLEAR_REQUEST_PARAMS
    payload: null
}

interface ClearCurrentText {
    type: MESSAGES_ACTION_CONSTANTS.CLEAR_CURRENT_TEXT
    payload: null
}


export type MessageActionTypes = SetMessagesAction | SetSelectedClient | ClearMessages | SetRequestParams | IncrementPage | ClearRequestParams | SetCurrentText | ClearCurrentText

export function messagesReducer(
    state = initialState,
    action: MessageActionTypes
): MessagesState {
    switch (action.type) {
        case MESSAGES_ACTION_CONSTANTS.ADD_MESSAGES:
            return {
                ...state,
                messages: action.payload.reverse().concat(state.messages)
            };
        case MESSAGES_ACTION_CONSTANTS.CLEAR_MESSAGES:
            return {
                ...state,
                messages: []
            };
        case MESSAGES_ACTION_CONSTANTS.SET_SELECTED_CLIENT:
            return {
                ...state,
                selectedClient: action.payload
            };
        case MESSAGES_ACTION_CONSTANTS.SET_REQUEST_PARAMS:
            return {
                ...state,
                requestParams: {
                    ...state.requestParams,
                    ...action.payload
                }
            };
        case MESSAGES_ACTION_CONSTANTS.SET_CURRENT_TEXT:
            return {
                ...state,
                currentText: action.payload
            };
        case MESSAGES_ACTION_CONSTANTS.INCREMENT_PAGE:
            return {
                ...state,
                requestParams: {
                    page: state.requestParams.page + 1
                }
            };
        case MESSAGES_ACTION_CONSTANTS.CLEAR_REQUEST_PARAMS:
            return {
                ...state,
                requestParams: defaultRequestParams
            };
        case MESSAGES_ACTION_CONSTANTS.CLEAR_CURRENT_TEXT:
            return {
                ...state,
                currentText: ''
            };
        default:
            return state
    }
}
