import React from 'react';

import styled from 'styled-components';
import Navbar from '../components/Navbar';
import { FiUser,  } from 'react-icons/fi'
import { AiOutlineMail } from 'react-icons/ai'
import { FaUserGraduate } from 'react-icons/fa'
import image from '../img/background-dollar.png';

const Container = styled.div`

    width: 80vw;
    margin: 0 auto;
    display: flex;

    div#left {
        width: 50%;
    }

    div#right {
        width: 50%;
        background: url(${image});
        background-position: center; 
        background-repeat: no-repeat;
        background-size: cover;

        form {
            background-color: #FFF;
            margin: 0 auto;
            margin-top: 30px;
            width: min(80%, 350px);

            div {
                position: relative;
                margin: 15px 0;
            }



            input, textarea {
                width: 100%;
                padding: 15px 5px;
                padding-left: 40px;
                background: rgba(0,0,0,.1);
                border: none
            }

            button {
                padding: 15px 40px;
                margin: 0 auto;
                background: #00DC88;
                border: none;
                border-radius: 5px
                font-weight: bold;
            }
        }
    }
`;

function Contato() {
  return (
      <>
        <Navbar />
        <Container>
            <div id="left">
                <h1>Entre em contato</h1>
                <p>(45) 2105.9001</p>
                <p>(45) 99860.5675</p>
                <p>secretaria@uniamerica.br</p>
                <p>Endereço: Av. das Cataratas, 1118 - Vila Yolanda, Foz do Iguaçu - PR, 85853-000</p>
            </div>
            <div id="right">
                <form>
                    <h1>Deixe uma mensagem</h1>
                    <div>
                        <FiUser style={{position:'absolute', top:'14px', left:'8px', color:'rgba(0,0,0,.6)'}} />
                        <input type="text" placeholder="Nome" />
                    </div>
                    <div>
                        <AiOutlineMail style={{position:'absolute', top:'14px', left:'8px', color:'rgba(0,0,0,.6)'}} />
                        <input type="text" placeholder="E-mail" />
                    </div>
                    <div>
                        <FaUserGraduate style={{position:'absolute', top:'14px', left:'8px', color:'rgba(0,0,0,.6)'}} />
                        <input type="text" placeholder="RA" />
                    </div>
                    <div>
                        <AiOutlineMail style={{position:'absolute', top:'14px', left:'8px', color:'rgba(0,0,0,.6)'}} />
                        <textarea placeholder="Mensagem" />
                    </div>

                    <button>Enviar</button>
                </form>
            </div>
        </Container>
      </>
  );
}

export default Contato;