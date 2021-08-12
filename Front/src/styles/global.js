import { createGlobalStyle } from "styled-components";

export default createGlobalStyle`

    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        overflow-x: hidden;
        background: #F0F0F7;
        text-decoration: none;
    }

    &:focus, &:hover, &:visited, &:link, &:active {
        text-decoration: none;
`;