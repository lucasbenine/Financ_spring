import styles from './style.css'
import { useState } from 'react'
import axios from 'axios'


function ModalContasDelete({show, close}){


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
        
        const deleteConta = {
            nomeConta: nome,
            valorConta: valor,
            categoria: categoria
        }

        e.preventDefault();

        axios.put("http://localhost:8080/contasareceber", deleteConta)
            .then(
                console.log(deleteConta),
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
                        <button type="submit" id="button_delete">Deletar</button>
                    </form>
                </div>
                <div className="wrapper"/>
            </div>
        </div>
    )
}

export default ModalContasDelete