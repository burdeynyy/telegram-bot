import React from "react";
import './styles.scss'
import classNames from "classnames";
import {Client} from "../../model";

export interface ClientProps {
    value: Client;
    onClick: (value: Client) => void;
    selected: boolean | undefined;
}

const ClientComponent: React.FC<ClientProps> = ({value, onClick, selected}) => {

    function handleOnClick(): void {
        onClick(value);
    }

    return (
        <div className={classNames('client', {client_selected: selected})}
             key={value.id}
             onClick={handleOnClick}>
            {value.name}
        </div>
    );
};

export default ClientComponent;
