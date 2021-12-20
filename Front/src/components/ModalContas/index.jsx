import styles from './style.css'
import { useState, useEffect } from 'react'
import axios from 'axios'
import api from '../../api';

function ModalContas({show, close}){

    const [nome, setNome] = useState("");
    const [valor, setValor] = useState("");
    const [categoria, setCategoria] = useState("");
    const [categorias, setCategorias] = useState([]);

    const handleChangeNome = (e) => {
        setNome(e.target.value)
    }

    const handleChangeValor = (e) => {
        setValor(e.target.value)
    }

    const handleChangeCategoria = (e) => {
        setCategoria(e.target.value)
    }

    useEffect(() => {

        async function buscarCategorias() {
            const response = await api.get('categorias');
            console.log(response); 
            setCategorias(response.data);       
        }
    
        buscarCategorias();
    }, [])

    function handleSubmit(e){
        
        const novaConta = {
            nomeConta: nome,
            valorConta: valor,
            categoria: {
                id: categoria
            }
        }

        e.preventDefault();

        axios.post("http://localhost:8080/contasapagar", novaConta)
            .then(
                console.log(novaConta),
                window.location.reload()
            )
    }

    return(
        <div className="div_main" style={{
            display: show ? "flex" : "none"
        }}>
            <div className="modal">
                <div id="fechar" onClick={close}>+</div>
                <form onSubmit={handleSubmit}>
                    <input type="text" placeholder="Nome" value={nome} onChange={handleChangeNome}/>
                    <input type="number" placeholder="Valor" value={valor} onChange={handleChangeValor}/>
                    <select defaultValue={'DEFAULT'} name="categoria" onChange={handleChangeCategoria} value={categoria} required="required">
                            <option selected="selected" value="default">Categoria</option>
                            {categorias?.map((item) => (
                                <option key={item.id} value={item.id}>{item.nomeCategoria}</option>
                            ))}
                        </select>
                    <button type="submit">Cadastrar</button>
                </form>
            </div>
            <div className="wrapper"/>
        </div>
    )
}

export default ModalContas