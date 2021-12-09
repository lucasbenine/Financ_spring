import React, { useState, useEffect } from 'react';
import axios from 'axios';
import api from '../../api';
import * as C from '../Modal/styles';

function ModalEdit({show, close, despesa, type}) {
    
    const [id, setId] = useState(500);
    const [nome, setNome] = useState("");
    const [preco, setPreco] = useState("");
    const [categoria, setCategoria] = useState("");
    const [data, setData] = useState("");
    const [descricao, setDescricao] = useState("");
    const [categorias, setCategorias] = useState([]);

    var url = "";

    useEffect(() => {
        if(type === "receitas") {
            url = "receita-categorias"
        }
        else {
            url = "categorias"
        }
    }, [])

    if(despesa.id && despesa.id !== id) {
        async function buscarDespesa(id) {

            const response = await api.get(`${type}/${despesa.id}`);
                console.log("Resposta meu ovo " + response); 
                setId(response.data.id);
                setNome(response.data.nome);    
                setPreco(response.data.preco);    
                setCategoria(response.data.categoria.id);    
                setData(response.data.data);    
                setDescricao(response.data.descricao);
        }

        buscarDespesa(despesa.id);
    }

    // useEffect(() => {

    //     async function buscarDespesa(id) {
    //         console.log("Teste do id" + id)
    //         const response = await api.get(`despesas/${id}`, config);
    //         console.log(response); 
    //         setNome(response.data.nome);    
    //         setPreco(response.data.preco);    
    //         setCategoria(response.data.categoria.nomeCategoria);    
    //         setData(response.data.data);    
    //         setDescricao(response.data.descricao);    
    //     }

    //     buscarDespesa(despesa.id);
    // }, despesa)


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

        // console.log(novaDespesa)

        axios.put(`http://localhost:8080/${type}/${id}`, novaDespesa)
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

                  <button type="submit" id="enviarDespesa" style={{background: type === 'despesas' ? '#ff7e7c' : '#00DC88'}}>Editar</button>


              </form>
          </div>
          <div className="wrapper" />
    </C.Container>

  );
}

export default ModalEdit;