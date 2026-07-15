import React from "react";

function UserPage() {

    return (

        <div>

            <h2>Welcome User</h2>

            <h3>Ticket Booking</h3>

            <table border="1" cellPadding="10">

                <thead>

                    <tr>

                        <th>Flight</th>
                        <th>From</th>
                        <th>To</th>

                    </tr>

                </thead>

                <tbody>

                    <tr>

                        <td>AI202</td>
                        <td>Chennai</td>
                        <td>Delhi</td>

                    </tr>

                    <tr>

                        <td>6E345</td>
                        <td>Bangalore</td>
                        <td>Mumbai</td>

                    </tr>

                </tbody>

            </table>

            <br />

            <button>Book Ticket</button>

        </div>

    );

}

export default UserPage;