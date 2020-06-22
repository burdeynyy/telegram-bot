import thunk, {ThunkAction} from "redux-thunk";
import {Action, applyMiddleware, combineReducers, createStore} from "redux";
import {clientsReducer, ClientsState} from "../clients/reducers";
import {messagesReducer, MessagesState} from "../messages/reducers";

export type AppThunk<ReturnType = void> = ThunkAction<ReturnType, AppStoreState, unknown, Action<string>>

export interface AppStoreState {
    clients: ClientsState;
    messages: MessagesState;
}

const rootReducer = combineReducers<AppStoreState>({
    clients: clientsReducer,
    messages: messagesReducer
});

export const store = createStore(rootReducer, applyMiddleware(thunk));
