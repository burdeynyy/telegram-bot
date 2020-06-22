import {MessageActionTypes} from "./reducers";
import {MESSAGES_ACTION_CONSTANTS} from "./constants";
import {Message} from "./model";
import {Client} from "../clients/model";

export function addMessages(messages: Message[]): MessageActionTypes {
    return {
        type: MESSAGES_ACTION_CONSTANTS.ADD_MESSAGES,
        payload: messages
    }
}

export function setSelectedClient(client: Client): MessageActionTypes {
    return {
        type: MESSAGES_ACTION_CONSTANTS.SET_SELECTED_CLIENT,
        payload: client
    }
}

export function clearMessages(): MessageActionTypes {
    return {
        type: MESSAGES_ACTION_CONSTANTS.CLEAR_MESSAGES,
        payload: null
    }
}

export function clearRequestParams(): MessageActionTypes {
    return {
        type: MESSAGES_ACTION_CONSTANTS.CLEAR_REQUEST_PARAMS,
        payload: null
    }
}

export function setCurrentText(text: string): MessageActionTypes {
    return {
        type: MESSAGES_ACTION_CONSTANTS.SET_CURRENT_TEXT,
        payload: text
    }
}

export function clearCurrentText(): MessageActionTypes {
    return {
        type: MESSAGES_ACTION_CONSTANTS.CLEAR_CURRENT_TEXT,
        payload: null
    }
}

export function incrementPage(): MessageActionTypes {
    return {
        type: MESSAGES_ACTION_CONSTANTS.INCREMENT_PAGE,
        payload: null
    }
}
