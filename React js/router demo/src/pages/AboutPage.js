import React from "react";
import { Link } from "react-router-dom";


export default function AboutPage(){
    return(
        <div>
            <h1>About Page</h1>
            <p>
                <Link to="/https://www.amazon.in/">Amazon</Link> on GitHub.
            </p>
        </div>
    );
}