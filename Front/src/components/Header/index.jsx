import React, { useState, useContext } from 'react';
import styled from 'styled-components';
import { IconContext } from 'react-icons';
import { GiHamburgerMenu } from "react-icons/gi";
import { FiFileMinus, FiFilePlus, FiHome, FiDollarSign, FiSettings, FiLogOut, FiBarChart2 } from 'react-icons/fi';
import { MdClose } from "react-icons/md";
import { Link } from 'react-router-dom';

import { Context } from '../../Context/AuthContext';


const HeaderContainer = styled.header`

    width: 100vw;
    height: 85px;
    background-color: #00346F;
    font-size: 16px;

    div#burguer {

        height: 100%;
        display: flex;
        align-items: center;
        margin-left: 10vw;
        cursor: pointer;

        span {
            padding: 10px;
        }
    }

    .nav-menu {
        position: relative;
        width: 250px;
        height: 100vh;
        position: fixed;
        top: 0;
        left: -100%;
        z-index: 5;
        background-color: #00346F;
        transition: 850ms;

        div#button-fechar {
            position: absolute;
            padding: 10px;
            cursor: pointer;
        }

        div#user {
            width: 100%;
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 20px;
            color: #00DC88;

            div#image {
                width: 150px;
                height: 150px;
                border-radius: 50%;
                background-color: #aaa;
                margin-bottom: 10px;
            }        
        }

        ul {
            width: 100%;
            display: flex;
            flex-direction: column;
            align-items: center;
            font-size: 20px;
            margin-top: 15px;

            li {
                width: 85%;
                color: #FFF;
                list-style: none;
                margin: 10px 0;
                padding: 10px;
                cursor: pointer;
                display: flex;
                align-items: center;

                a {
                    display: flex;
                    align-items: center;
                }

                span {
                    margin-left: 5px;
                    color: #FFF;
                }
            }
        }

    }

    .nav-menu.active {
        left: 0;
        transition: 350ms;
    }
`;

function Header() {

    const [sidebar, setSidebar] = useState(false);

    const showSidebar = () => setSidebar(!sidebar);

    const { handleLogout } = useContext(Context);


  return (
      <HeaderContainer>
          <IconContext.Provider value={{ color: '#00DC88', size:'1.5rem' }}>
            <div id="burguer" onClick={showSidebar}>
                <GiHamburgerMenu />
            </div>
            <nav className={sidebar ? 'nav-menu active' : 'nav-menu'}>
                <div id="button-fechar" onClick={showSidebar}><MdClose /></div>
                <div id="user">
                    <div id="image">
                        {/* <img src={} /> */}
                    </div>
                    <h2>Luisa Ghellere</h2>
                    <p>RA: 501792</p>
                </div>
                <ul>
                    
                    <li>
                        <Link to="/inicio">
                            <FiHome />
                            <span>Home</span>
                        </Link>
                    </li>
                    <li>
                        <Link to="/receitas">
                            <FiFilePlus />
                            <span>Receitas</span>
                        </Link>
                    </li>
                    <li>
                        <Link to="/despesas">
                            <FiFileMinus />
                            <span>Despesas</span>
                        </Link>
                    </li>
                    <li>
                        <Link to="/movimentacao">
                            <FiBarChart2 />
                            <span>Movimentação</span>
                        </Link>
                    </li>
                    <li>
                        <Link to="/contasapagar">
                            <FiDollarSign />
                            <span>Contas</span>
                        </Link>
                    </li>
                    <li>
                        <Link to="/">
                            <FiSettings />
                            <span>Configurações</span>
                        </Link>
                    </li>
                    <li onClick={handleLogout}>
                        <FiLogOut />
                        <span>Logout</span>
                    </li>

                </ul>
            </nav>
          </IconContext.Provider>
      </HeaderContainer>  
  );
}

export default Header;