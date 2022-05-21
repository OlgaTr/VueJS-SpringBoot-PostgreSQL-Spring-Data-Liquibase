import React from "react";
import {render as myRender} from "@testing-library/react";
import {configureStore} from "@reduxjs/toolkit";
import {Provider} from "react-redux";

import userSlice from "../app/userSlice";

function render(
    ui,
    {
        preloadedState,
        store = configureStore({reducer: {user: userSlice}, preloadedState}),
        ...rederOptions
    } = {}
) {
    function Wrapper({children}) {
        return <Provider store={store}>{children}</Provider>
    }
    return myRender(ui, {wrapper: Wrapper, ...rederOptions})
}

export * from '@testing-library/react'
export {render}