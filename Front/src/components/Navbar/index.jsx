import styled from 'styled-components';
import { useState } from 'react';
import Logo from '../../img/logofinance.png'
import {Link} from 'react-router-dom';
import { IoIosMenu } from 'react-icons/io';

const Nav = styled.div `
    width: 100%;
    height: 8vh;
    background: #8DB892;
    display: flex;
    justify-content: space-between;
    align-items: center;
    border-bottom: 2px solid white;

    img {
        width: 100%;
        padding: auto;
    }
`;

const Navlist = styled.ul `
    width: 30%;
    height: 100%;
    display: flex;
    justify-content: space-around;
    align-items: center;
    list-style: none;

    .link-navbar {
        color: transparent;
        width: 30%;
    }

    @media(max-width: 1440px) {
        font-size: 1em;
        margin-right: 3em;
    }

    @media (max-width: 1024px) {
        flex-flow: column nowrap;
        margin-right: 0;
        background-color: #8DB892;
        display: ${({open}) => open ? 'block' : 'none'};
        position: absolute;
        margin-top: 35%;
        right: 2em;
        height: 29vh;
        border-radius: 10px;
        border: 2px solid #F0F0F7;
        text-align: center;

        li {
            justify-content: space-around;
            align-items: center;
        }
    }
`;

const Normalbuttons = styled.button `
    border: 2px solid transparent;
    outline: none;
    width: 100%;
    padding: 1%;
    font-size: 1em;
    background: transparent;
    cursor: pointer;
    color: #04660E;
    transition: .5s;

    @media(max-width: 1440px) {
        padding: .4em;
        font-size: 1em;
    }

    @media(max-width: 1024px) {
        font-size: 1em;
        padding: 1em;
    }


    :hover {
        color: #F0F0F7;
        border-bottom: 2px solid #F0F0F7;
    }
`;

const Styledbuttons = styled.button `
    border: 2px solid #04660E;
    border-radius: 8px;
    outline: none;
    width: 100%;
    padding: .6em;
    font-size: 1em;
    background: transparent;
    cursor: pointer;
    color: #04660E;
    transition: .5s;

    @media(max-width: 1440px) {
        padding: .4em;
        font-size: 1em;
    }

    @media(max-width: 1024px) {
        padding: 1em;
        font-size: 1em;
        width: 60%;

        :first-child {
            margin-bottom: 1em;
        }
    }

    :hover {
        background: #04660E;
        border: 2px solid #F0F0F7;
        color: #F0F0F7;
    }
`;

const Burger = styled.button `
    width: 5%;
    height: 45%;
    background: transparent;
    outline: none;
    border: ${({open}) => open ? '2px solid #F0F0F7' : '2px solid #04660E'};
    display: flex;
    justify-content: center;
    align-items: center;
    margin-right: 1.8em;
    border-radius: 6px;
    transition: .5s;

    :onClick {
        border: 2px solid #F0F0F7
    }

    .burger-icon {
        color: ${({open}) => open ? '#F0F0F7' : '#04660E'};
        transition: .5s;
    }

    @media (min-width: 1024px) {
        display: none;
    }
`;

 const linkStyle = {
    color: 'transparent',
    width: '8%',
    height: '100%',
    display: 'flex',
    alignItems: 'center',
    marginLeft: '1.8em'
 };

function Navbar() {

    const [open, setOpen] = useState(false);

    return(
        <Nav>
            <Link className="link" to="/Home" style={linkStyle}>
                <img className="logofinanc" src={Logo} alt="Logo Financ"/>
            </Link>
            <Navlist open={open}>
                <li>
                    <Link className="link-navbar" to="/Home">
                        <Normalbuttons>Sobre</Normalbuttons>
                    </Link>
                </li>
                <li>
                    <Link className="link-navbar" to="/contato">
                        <Normalbuttons>Contato</Normalbuttons>
                    </Link>
                </li>
                <li>
                    <Link className="link-navbar" to="/login">
                        <Styledbuttons>Login</Styledbuttons>
                    </Link>
                </li>
                <li>
                    <Link className="link-navbar" to="/cadastro">
                        <Styledbuttons>Cadastro</Styledbuttons>
                    </Link>
                </li>
            </Navlist>
            <Burger open={open} onClick={() => setOpen(!open)}>
                <IoIosMenu size={30} className="burger-icon"/>
            </Burger>
        </Nav>
    )
}

export default Navbar;