import {configureStore} from "@reduxjs/toolkit";
import userSlice from "./userSlice";
import {persistReducer} from "redux-persist";
import storage from 'redux-persist/lib/storage'

const persistConfig = {
    key: 'root',
    storage,
}

const persistedReducer = persistReducer(persistConfig, userSlice)

export default configureStore(({
    reducer: {
        user: persistedReducer
    }
}))