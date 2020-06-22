import {setClients} from "./action";
import {AppThunk} from "../common/store";

export const loadClients = (): AppThunk =>
    async dispatch => {
        fetch('/api/clients')
            .then(res => res.json())
            .then(data => dispatch(setClients(data.content)))
    };
