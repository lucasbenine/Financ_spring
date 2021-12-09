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

    .apexcharts-legend {
        flex-wrap: wrap;
        width: 300px
    }

    body {
        overflow-x: hidden;
    }

    button {
        cursor: pointer;
    }

    .despesa {
        color: #ff7e7c;
    }

    .wrapper {
        width: 100%;
        height: 100%;
        position: fixed;
        overflow: hidden;
        opacity: .5;
        z-index: 98;
        top: 0;
        left: 0;
        background: rgba(0,0,0,.4);
    }
`;