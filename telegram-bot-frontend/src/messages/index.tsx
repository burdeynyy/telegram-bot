import React, {ChangeEvent} from 'react';
import './styles.scss'
import MessageComponent from "./components/message";
import {useDispatch, useSelector} from "react-redux";
import {getCurrentText, getMessages, getSelectedClient} from "./selectors";
import {fetchMessagesByClientId, sendMessageToClient} from "./thunks";
import {
    clearCurrentText,
    clearMessages,
    clearRequestParams,
    incrementPage,
    setCurrentText,
} from "./action";
import RefreshButton from "../common/refresh-button/refresh-button";


const MessagesComponent: React.FC = () => {

    const messagesEndRef = React.useRef<HTMLDivElement>(null);
    const messagesRef = React.useRef<HTMLDivElement>(null);

    const messages = useSelector(getMessages);
    const selectedClient = useSelector(getSelectedClient);
    const text = useSelector(getCurrentText);

    const dispatch = useDispatch();

    const scrollToBottom = () => messagesEndRef?.current?.scrollIntoView(false);

    React.useEffect(() => {

        dispatch(clearMessages());
        dispatch(clearRequestParams());
        if (selectedClient && selectedClient.id) {
            dispatch(fetchMessagesByClientId(selectedClient.id, scrollToBottom));
        }
        dispatch(clearCurrentText());
    }, [selectedClient]);

    function handleSend() {
        dispatch(sendMessageToClient(scrollToBottom))
    }

    function onChangeHandler(event: React.ChangeEvent<HTMLTextAreaElement>) {
        dispatch(setCurrentText(event.target.value));
    }

    function loadMoreHandler() {
        if (selectedClient && selectedClient.id) {
            dispatch(incrementPage());
            dispatch(fetchMessagesByClientId(selectedClient.id));
        }
    }

    function refreshMessagesHandler() {
        dispatch(clearMessages());
        dispatch(clearRequestParams());
        if (selectedClient && selectedClient.id) {
            dispatch(fetchMessagesByClientId(selectedClient.id, scrollToBottom));
        }
    }

    return (
        <>
            {selectedClient ?
                <>
                    <div className="messages" ref={messagesRef}>
                        <div className="messages__header">
                            <div className="messages__title">Chat with {selectedClient.name}</div>
                            <div className="messages__refresh">
                                <RefreshButton onClick={refreshMessagesHandler}/>
                            </div>
                        </div>
                        <div className="messages__content">
                            <div className="messages__load" onClick={loadMoreHandler}>Load more...</div>

                            {messages.map((msg) => (
                                <MessageComponent key={msg.id} message={msg} senderName={selectedClient.name}/>
                            ))}
                            <div ref={messagesEndRef}/>
                        </div>
                    </div>
                    <form className="send-message-form">
                        <div className="col-lg-10">
                <textarea className="send-message-form__content" name="content"
                          placeholder={"Your message..."} value={text} onChange={onChangeHandler}/>
                        </div>
                        <div className="col-lg-2">
                            <button type="button" className="send-message-form__button" onClick={handleSend}>Send
                            </button>
                        </div>
                    </form>
                </>
                : <p>Select client to open the chat...</p>}
        </>

    );
};

export default MessagesComponent;
