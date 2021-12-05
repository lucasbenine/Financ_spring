import styles from '../styles/Contas'

function ContasAPagar(){

    const green = "green";

    return(
        <div>
            <div className="two_divs">
                <div className="balanco_mensal">
                    <h1>Balanço mensal - Contas Fixas:</h1>
                    <h2>Gráfico</h2>
                </div>
                <div className="relatorio_contas">
                    <button className={green}>Relatório de Contas</button>
                    <button className={green}>Adicionar Saída</button>
                    <button className={green}>Editar Saída</button>
                    <button className={green}>Remover Saída</button>
                </div>
            </div>    
                <div className="lancamentos">
                    <div className="border_one">
                        <h1>Contas A Pagar</h1>
                    </div>
                    <ul>
                        <li>Aluguel</li>
                        <li>Energia</li>
                    </ul>
                </div>  
        </div> 
    )
}

export default ContasAPagar