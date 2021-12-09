import styles from './style.css'
import { useState } from 'react'
import axios from 'axios'

function ModalContas({show, close}){

    const [nome, setNome] = useState("");
    const [valor, setValor] = useState("");
    const [categoria, setCategoria] = useState("");

    const handleChangeNome = (e) => {
        setNome(e.target.value)
    }

    const handleChangeValor = (e) => {
        setValor(e.target.value)
    }

    const handleChangeCategoria = (e) => {
        setCategoria(e.target.value)
    }

    function handleSubmit(e){
        
        const novaConta = {
            nomeConta: nome,
            valorConta: valor,
            categoria: categoria
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
                    <input type="text" placeholder="Categoria" value={categoria} onChange={handleChangeCategoria}/>
                    <button type="submit">Cadastrar</button>
                </form>
            </div>
            <div className="wrapper"/>
        </div>
    )
}

export default ModalContas