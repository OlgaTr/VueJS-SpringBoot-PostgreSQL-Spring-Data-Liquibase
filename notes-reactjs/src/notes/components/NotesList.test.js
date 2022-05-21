import React from "react";
import {rest} from "msw";
import {setupServer} from "msw/node";
import {render, screen} from "../../utils/test-utils";
import {BASE_URL} from "../api/NoteAPI";
import NotesList from "./NotesList";

const fakeNotes = [
    {
        date: '2022-19-09',
        title: 'A note',
        content: `Just because I choose not to drink doesn't automatically make me no fun. That is a separate choice which I've also made`
    },
    {
        date: '2022-19-09',
        title: 'Coffee',
        content: 'Life is just alternating between telling people "sorry im being weird i had too much coffee"' +
            `and "sorry im being weird i haven't had enough coffee"`
    }
]

function findAddNoteButton() {
    return screen.getByRole('button', {name: 'Add note'});
}

export const handlers = [
    rest.get(`${BASE_URL}/notes`, (req, res, ctx) => {
        return res(ctx.json([]), ctx.delay(150))
    })
]

const server = setupServer(...handlers)

beforeAll(() => server.listen());
beforeEach(() => render(<NotesList />))
afterEach(() => server.resetHandlers())
afterAll(() => server.close())

const mockedUseNavigate = jest.fn();

jest.mock('react-router-dom', () => ({
    ...jest.requireActual('react-router-dom'),
    useNavigate: () => mockedUseNavigate
}));

describe('Top view rendering without notes', () => {

    test (`'Add note' button is displayed`,  () => {
        const addNoteButton = findAddNoteButton();
        expect(addNoteButton).not.toBeNull();
    })

    test('"Add note" message is displayed', () => {
        expect(screen.getByText(/Add your first note/i)).not.toBeNull();
    })
})

// describe('List rendering - two notes present', () => {
//
//     test('"Add your first note" message is not displayed', () => {
//         expect(screen.getByText(/Add your first note/i)).toBeNull();
//     })
//
//     test('Both note titles are displayed', () => {
//         const addNoteButton = findAddNoteButton();
//         expect(addNoteButton).not.toBeNull();
//
//         fakeNotes.forEach(({title}) => {
//             expect(screen.queryByText(title, {exact: true})).not.toBeNull();
//         })
//     })
// })