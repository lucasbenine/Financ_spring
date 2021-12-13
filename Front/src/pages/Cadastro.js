import styled from 'styled-components';
import Logo from '../img/logo.png';
import {Link} from 'react-router-dom';
import history from '../history'
import { useState } from 'react';
import Carousel1 from '../img/carousel3.png';
import api from '../api';

const CadastroWrapper = styled.div`
    width: 100vw;
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
`

const CadastroContainer = styled.div `
    width: 70%;
    height: 80%;
    display: flex;
    box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;

    .form-wrapper {
        width: 45%;
        height: 100%;
        display: flex;
        flex-flow: column nowrap;
        align-items: center;
        justify-content: center;

        .logo-financ {
            width: 50%;
            height: auto;
        }

        .cadastro-form {
            margin-top: 6%;
            display: flex;
            flex-flow: column nowrap;
            align-items: center;
            justify-content: center;
            width: 65%;

            .form-input {
                width: 100%;
                padding: 1rem;
                margin-top: 5%;
                border-radius: 3px;
                outline: none;
                border: 2px solid transparent;
                font-size: 1rem;
                background-color: #e6e6e6;
                color: black;
                transition: .3s;
            }

            .form-input:focus{
                border: 2px solid #00DC88;
            }

            .checkbox {
                margin-top: 5%;
                width: 80%;
                display: flex;
                align-items: center;
                justify-content: center;
            }

            .cadastro-button {
                margin-top: 5%;
                width: 70%;
                padding: 1rem;
                font-size: 1.4rem;
                outline: none;
                border: none;
                background-color: #00DC88;
                border-radius: 3px;
                font-weight: bold;
                transition: .5s;
            }

            .cadastro-button:hover {
                background-color: #00346F;
                color: white;
            }

        }
    }

    //CAROUSELL 

    .green {
        width: 55%;
        background-color: #00DC88;
        display: flex;
        align-items: center;
        justify-content: center;

        img {
            min-width: 360px;
            max-width: 34%;
            height: auto;
            position: absolute;
            bottom: 10%;
        }
    }

    @media(max-width: 1025px) {
        width: 90%;
    }

    @media (max-width: 767px) {
        .green {
            display: none;
        }

        .form-wrapper {
            width: 100%;
        }
    }

    @media(max-width: 451px) {
        
        .logo-financ {
            width: 70%;
        }
    }

`;

function Cadastro () {

    const [senha, setSenha] = useState(false);
    const [nome, setNome] = useState('');
    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');
    const [email, setEmail] = useState('');

    function HandleCadastro(){
        const data = { 
            nome: nome,
            username: userName,
            password: password,
            email: email
        }

        api.post('contatos', data)
        .then(() => {
            alert("Contato cadastrado com sucesso!")
            history.push('/login');
        }).catch(() => {
            alert("Falha ao cadastrar este usuario. Por favor, preencha os campos novamente")
        })
    }
    return(
        <CadastroWrapper>
            <CadastroContainer>
                <div className="form-wrapper">
                    <img src={Logo} className="logo-financ" alt="Logo Financ" />
                    <form className="cadastro-form" onSubmit={HandleCadastro}>
                        <input className="form-input" required="required" type="text" placeholder="Nome Completo" name="name" onChange={(e) => setNome(e.target.value)}/>
                        <input className="form-input" required="required" type="text" placeholder="Nome de Usuario" name="username" onChange={(e) => setUserName(e.target.value)}/>
                        <input className="form-input" required="required" type="text" placeholder="Email" name="email" onChange={(e) => setEmail(e.target.value)}/>
                        <input className="form-input" required="required" type={senha ? "text" : "password"} placeholder="Senha" name="password" onChange={(e) => setPassword(e.target.value)}/>
                        <input className="form-input" required="required" type={senha ? "text" : "password"} placeholder="Confirmar senha"/>
                        <div className="checkbox">
                            <input type="checkbox" onChange={() => setSenha(!senha)}/>
                            <span>Mostrar senha?</span>
                        </div>
                        <button className="cadastro-button" type="submit">Cadastrar</button>
                    </form>
                </div>
                <div className="green">
                    <img src={Carousel1} alt="Moça com um pote de dinheiro" />
                </div>
            </CadastroContainer>
        </CadastroWrapper>
    )
}

export default Cadastro;