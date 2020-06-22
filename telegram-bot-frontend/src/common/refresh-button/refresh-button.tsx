import React from 'react';
import './styles.scss'

export interface RefreshButtonProps {
    onClick: () => void;
}

const RefreshButton: React.FC<RefreshButtonProps> = ({onClick}) => {
    
    function refreshClientsHandler() {
        onClick();
    }

    return (
        <div className="refresh-button" onClick={refreshClientsHandler}/>
    );
};

export default RefreshButton;
