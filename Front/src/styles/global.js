import { createGlobalStyle } from "styled-components";

export default createGlobalStyle`
    @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap');

    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        text-decoration: none;
        font-family: 'Roboto', sans-serif;
    }

    body {
        overflow-x: hidden;
        background: #F0F0F7;
    }

    .despesa {
        color: #ff7e7c;
    }
`;