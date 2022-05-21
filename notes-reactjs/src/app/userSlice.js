import {createSlice} from "@reduxjs/toolkit";

const userSlice = createSlice({
    name: 'user',
    initialState: {
        username: '',
        password: ''
    },
    reducers: {
        setCurrentUser(state, action) {
            const {username, password} = action.payload
            state.username = username;
            state.password = password;
        },
        removeCurrentUser(state) {
            state.username = ''
            state.password = ''
        }
    }
})

export const {setCurrentUser, removeCurrentUser} = userSlice.actions;

export default userSlice.reducer;

export const selectUsername = state => state.user.username;
export const selectPassword = state => state.user.password;