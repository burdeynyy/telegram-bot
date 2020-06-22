import React from "react";
import './styles.scss'
import classNames from "classnames";
import {Message} from "../../model";

export interface MessageProps {
    message: Message;
    senderName: string;
}

const MessageComponent: React.FC<MessageProps> = ({message, senderName}) => {

    return (
        <div className={classNames('message', {message_answer: message.botAnswer})}>
            <div className="message__header">
                <div className="message__header-left">
                    <div className="message__from">{message.botAnswer ? 'You' : senderName}</div>
                    <div className="message__datetime">at {message.creationDate}</div>
                </div>
            </div>
            <div className="message__content">
                {message.content}
            </div>
        </div>
    );
};

export default MessageComponent;
