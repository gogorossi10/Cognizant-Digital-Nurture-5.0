import React, { useState } from "react";

import "./App.css";

import GuestPage from "./Components/GuestPage";
import UserPage from "./Components/UserPage";

function App() {

    const [loggedIn, setLoggedIn] = useState(false);

    return (

        <div style={{ margin: "20px" }}>

            <h1>Ticket Booking Application</h1>

            {

                loggedIn ?

                    <div>

                        <button onClick={() => setLoggedIn(false)}>
                            Logout
                        </button>

                        <hr />

                        <UserPage />

                    </div>

                    :

                    <div>

                        <button onClick={() => setLoggedIn(true)}>
                            Login
                        </button>

                        <hr />

                        <GuestPage />

                    </div>

            }

        </div>

    );

}

export default App;