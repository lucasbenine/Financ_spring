import React, { useState, useEffect } from 'react';
import axios from 'axios';
import api from '../../api';
import { ca } from 'date-fns/locale';
import * as C from './styles';

function Modal({show, close, type}) {

    const [nome, setNome] = useState("");
    const [preco, setPreco] = useState("");
    const [categoria, setCategoria] = useState("");
    const [data, setData] = useState("");
    const [descricao, setDescricao] = useState("");
    const [categorias, setCategorias] = useState([]);

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

        axios.post(`http://localhost:8080/${type}`, novaDespesa)
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

        var url = 'categorias'

        if(type === 'receitas') {
            url = 'receita-categorias';
        }

        async function buscarCategorias() {
            const response = await api.get(url);
            console.log(response); 
            setCategorias(response.data);       
        }
    
        buscarCategorias();
    }, [])


  return (
      <C.Container style={{
          display: show ? 'flex' : 'none'
      }}>
            <div id="modal-container" style={{borderColor: type === 'despesas' ? '#ff7e7c' : '#00DC88'}}>
                <div id="fechar" onClick={close}>+</div>
                <div id="headerModal"><h3>{type}</h3></div>

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

                    <button type="submit" id="enviarDespesa" style={{background: type === 'despesas' ? '#ff7e7c' : '#00DC88'}}>Adicionar</button>


                </form>
            </div>
            <div className="wrapper" />
      </C.Container>
  );
}

export default Modal;