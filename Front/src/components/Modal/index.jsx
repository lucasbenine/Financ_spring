import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import axios from 'axios';
import api from '../../api';
import token from "../../token";
import { ca } from 'date-fns/locale';

const Container = styled.div`
    width: 100%;
    height: 100%;
    position: fixed;
    bottom: 0;
    left: 0;
    display: flex;
    justify-content: center;
    align-items: center;

    div#modal-container {
        width: 550px;
        height: 600px;
        background-color: #FFF;
        padding: 30px;
        position: relative;
        
        border-radius: 10px;
        border: 2px solid #FE6161;
        z-index: 99;

        #fechar {
            position: absolute;
            top: 0;
            right: 15px;
            font-size: 35px;
            transform: rotate(45deg);
            cursor: pointer;
        }

        #headerModal {
            margin-bottom: 70px;
            padding: 5px !important;
            font-size: 30px;
        }

        form {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;

            .input-despesas{
                width: 220px;
                margin-bottom: 60px;

                label {
                    position: relative;
                    margin-left: 2px;
                }

                input, select, textarea {
                    width: 100%;
                    padding: 10px 5px;
                    border-radius: 10px;
                    border: 1px solid rgba(0,0,0.4);
                    margin-top: 5px;
                }

                textarea {
                    height: 150px;
                    resize: none;
                    
                }
            }

            button {
                padding: 10px 20px;
                height: 50px;
                margin-top: 100px;
                background: #ff7e7c;
                color: #FFF;
                border: none;
                border-radius: 10px;

                margin-right: 10px;
                font-size: 20px;
            }
        }
    }
`;

function Modal({show, close}) {

    const [nome, setNome] = useState("");
    const [preco, setPreco] = useState("");
    const [categoria, setCategoria] = useState("");
    const [data, setData] = useState("");
    const [descricao, setDescricao] = useState("");
    const [categorias, setCategorias] = useState([]);

    const config = {
        headers: {
            'Authorization': `Bearer ${token}`
        }
    };

    function handleSubmit(event) {
        const novaDespesa = {
            nome: nome,
            preco: preco,
            categoria: {
                id: categoria
            },
            data: data,
            descricao: descricao,
        }

        event.preventDefault();

        console.log(novaDespesa)

        axios.post('http://localhost:8080/despesas', novaDespesa, config)
            .then(
                window.location.reload()
            )
            
    }

    const handleChangeTitulo = (e) => {
        setNome(e.target.value);
        console.log(e.target.value);
    }

    const handleChangeValor = (e) => {
        setPreco(e.target.value);
        console.log(e.target.value);
    }
    const handleChangeCategoria = (e) => {
        setCategoria(e.target.value)
        console.log(e.target.value);
    }
    const handleChangeData = (e) => {
        setData(e.target.value)
        console.log(e.target.value);
    }
    const handleChangeDescricao = (e) => {
        setDescricao(e.target.value)
        console.log(e.target.value);
    }


    useEffect(() => {

        async function buscarCategorias() {
            const response = await api.get('categorias', config);
            console.log(response); 
            setCategorias(response.data);       
        }
    
        buscarCategorias();
    }, [])


  return (
      <Container style={{
          display: show ? 'flex' : 'none'
      }}>
            <div id="modal-container">
                <div id="fechar" onClick={close}>+</div>
                <div id="headerModal"><h3>Despesas</h3></div>

                <form onSubmit={handleSubmit}>

                    <div className="input-despesas">
                        <label className="input-label">Titulo</label>
                        <input name="titulo" onChange={handleChangeTitulo} value={nome} className="form-despesas" type="text" placeholder="Titulo" required="required"/><br/>
                    </div>
                    
                    <div className="input-despesas">
                        <label className="input-label">Preço</label>
                        <input name="preco" onChange={handleChangeValor} value={preco} className="form-despesas" type="number" placeholder="Preço" required="required"/><br/>
                    </div>

                    <div className="input-despesas">
                        <label className="input-label">Categoria</label>
                        <select defaultValue={'DEFAULT'} name="categoria" onChange={handleChangeCategoria} value={categoria} required="required">
                            <option selected="selected" value="default">Categoria</option>
                            {categorias?.map((item) => (
                                <option key={item.id} value={item.id}>{item.nomeCategoria}</option>
                            ))}
                        </select>
                    </div>

                    <div className="input-despesas">
                        <label className="input-label">Data</label>
                        <input name="data" onChange={handleChangeData} value={data} className="form-despesas" type="date" placeholder="Data" required="required"/>
                    </div>

                    <div className="input-despesas">
                        <label className="input-label">Descrição</label>
                        <textarea name="descricao" onChange={handleChangeDescricao} value={descricao} id="descricao" placeholder="Descrição"></textarea>
                    </div>

                    <button type="submit" id="enviarDespesa">Adicionar</button>


                </form>
            </div>
            <div className="wrapper" />
      </Container>
  );
}

export default Modal;