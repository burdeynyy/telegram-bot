import {clearCurrentText, clearMessages, clearRequestParams, addMessages} from "./action";
import {Message} from "./model";
import {AppThunk} from "../common/store";

export const fetchMessagesByClientId = (clientId: number, scrollFunction?: () => void): AppThunk => {
    return async (dispatch, getState) => {
        const {messages: {requestParams: {page}}} = getState();
        fetch(`/api/clients/${clientId}/messages?page=${page}`)
            .then(res => res.json())
            .then(data => dispatch(addMessages(data.content)))
            .then(() => scrollFunction ? scrollFunction() : {});
    }
};


export const sendMessageToClient = (scrollFunction?: () => void): AppThunk => {
    return async (dispatch, getState) => {
        const {messages: {selectedClient, currentText, messages}} = getState();
        if (selectedClient && messages.length > 0) {
            const latestMessage = messages[messages.length - 1];
            const clientId = selectedClient.id;
            const newMessage: Partial<Message> = {
                botAnswer: true,
                content: currentText,
                chatId: latestMessage.chatId,
            };
            fetch(`/api/clients/${clientId}/messages`, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json, text/plain, */*',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newMessage)
            })
                .then(() => dispatch(clearRequestParams()))
                .then(() => dispatch(clearMessages()))
                .then(() => dispatch(clearCurrentText()))
                .then(() => dispatch(fetchMessagesByClientId(clientId, scrollFunction)));
        }
    }
};
