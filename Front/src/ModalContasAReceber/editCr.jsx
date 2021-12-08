import styles from './styleCr.css'
import { useState } from 'react'
import axios from 'axios'

function ModalContasCrEdit({show, close}){


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
        
        const editConta = {
            nomeConta: nome,
            valorConta: valor,
            categoria: categoria
        }

        e.preventDefault();

        axios.put("http://localhost:8080/contasareceber", editConta)
            .then(
                console.log(editConta),
                // window.location.reload()
            )
    }

    return(
        <div>
                <div className="div_main" style={{
                    display: show ? "flex" : "none"
                }}>
                <div className="modal">
                    <div id="fechar" onClick={close}>+</div>
                    <form>
                        <input type="text" placeholder="Nome" value={nome} onChange={handleChangeNome}/>
                        <input type="number" placeholder="Valor" value={valor} onChange={handleChangeValor}/>
                        <input type="text" placeholder="Categoria" value={categoria} onChange={handleChangeCategoria}/>
                        <button type="submit">Atualizar</button>
                    </form>
                </div>
                <div className="wrapper"/>
            </div>
        </div>
    )
}

export default ModalContasCrEdit