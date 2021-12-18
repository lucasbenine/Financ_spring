import styled from 'styled-components';
import Logo from '../../img/logo.png';
import { Link } from 'react-router-dom';
import { GiHamburgerMenu } from 'react-icons/gi';
import { MdClose } from 'react-icons/md';
import { useState } from 'react';

const NavBody = styled.div `
    background: #FFFFFF;
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
`;

const NavContent = styled.div `
    width: 80%;
    display: flex;
    align-items: center;
    justify-content: space-between;
    border-bottom: 2px solid #00DC88;

    a {
        width: 15%;
    } 

    .logo-financ {
        height: auto;
        width: 100%;
        padding: .8rem;
    }

    .buttons {
        width: 60%;
        display: flex;
        align-items: center;
        justify-content: space-between;
        padding: .8rem;
    }

    .close-button{
        display: none;
    }

    a {
        width: 20%;
        height: auto;
    }

    .buttons-button {
        width: 100%;
        height: 100%;
        padding: 10%;
        cursor: pointer;
        color: black;
        background-color: #00DC88;
        border: 1.5px solid transparent;
        outline: none;
        border-radius: 5px;
        font-size: 100%;
        font-weight: 400;
        transition: .3s;
    }

    .buttons-button:hover {
        background-color: #FFFFFF;
        color: #00346F;
        border: 1.5px solid #00346F;
    }

    .burger-menu-button {
        display: none;
        border: none;
        outline: none;
        background-color: #FFFFFF;
    }

    @media(max-width: 1025px) {
        a {
            width: 25%;
        }
    }

    @media(max-width: 800px) {
        .logo-financ{
            height: auto;
            width: 22%;
        }

        .buttons {
            display: none;
        }

        .close-button{
            display: block;
        }

        .burger-menu-button{
            display: block;
            padding: 2%;
        }

        a{
            width: 40%;
            margin-top: 5%;
        }

        .buttons-button {
            padding: 2%;
            margin: 10px;
        }

        @media(max-width: 426px) {
            .logo-financ {
                height: auto;
                width: 35%;
            }
    }
`;

const MobileNav = styled.div `
    
    width: 40%;
    flex-flow: column nowrap;
    position: absolute;
    display: flex;
    background-color: #FFFFFF;
    align-items: start;
    height: 100%;
    justify-content: unset;
    top: .1%;
    left: 60%;
    box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;

    body {
        opacity: .5 !important;
    }

    a {
        width: 20%;
        height: auto;
    }

    .buttons-button {
        width: 100%;
        height: 100%;
        padding: 10%;
        cursor: pointer;
        color: black;
        background-color: #00DC88;
        border: 1.5px solid transparent;
        outline: none;
        border-radius: 5px;
        font-size: 100%;
        font-weight: 400;
        transition: .3s;
    }

    .buttons-button:hover {
        background-color: #FFFFFF;
        color: #00346F;
        border: 1.5px solid #00346F;
    }

    .burger-menu-button {
        display: none;
        border: none;
        outline: none;
        background-color: #FFFFFF;
    }

    @media(max-width: 800px) {
        .close-button{
            display: block;
            margin-top: 10%;
            margin-left: 10px;
        }

        .burger-menu-button{
            display: block;
            padding: 2%;
        }

        a{
            width: 40%;
            margin-top: 5%;
        }

        .buttons-button {
            padding: 2%;
            margin: 10px;
        }
    }

    @media(max-width: 426px) {
        width: 60%;
        left: 40%;

        a{
            width: 70%;
        }

        .buttons-button {
            width: 100%;
        }
    }
    }
}

`;

function Navbar() {

    const [open, setOpen] = useState(false);

    return(
        <NavBody>
            <NavContent>
                <Link to="/">
                    <img className="logo-financ" src={Logo} alt="Logo FinanC" />
                </Link>
                { open == false ? 
                
                <div id="buttons" className="buttons">
                    <Link to="/contato">
                        <button className="buttons-button">Contato</button>
                    </Link>
                    <Link>
                        <button className="buttons-button">Sobre Nós</button>
                    </Link>
                    <Link to="/login">
                        <button className="buttons-button">Login</button>
                    </Link>
                </div>
                
                    :

                <MobileNav>
                    <MdClose size={35} className="close-button" onClick={() => setOpen(!open)}/>
                    <Link to="/contato">
                        <button className="buttons-button">Contato</button>
                    </Link>
                    <Link>
                        <button className="buttons-button">Sobre Nós</button>
                    </Link>
                    <Link to="/login">
                        <button className="buttons-button">Login</button>
                    </Link>
                </MobileNav>
                }

                <button className="burger-menu-button" onClick={() => setOpen(!open)}>
                    <GiHamburgerMenu size={25}/>
                </button>
            </NavContent>
        </NavBody>
    )
}

export default Navbar;