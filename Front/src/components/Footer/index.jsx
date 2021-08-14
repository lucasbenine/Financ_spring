import styled from 'styled-components';

const footerBody = styled.div `
    background: #8DB892;
    width: 100vw;
    height: 10vh;
    display: flex;
    justify-content: space-around;
    align-items: center;
    text-align: center;
    color: white;
    position: fixed-bottom;
    display: block;
`;

function Footer() {
    return(
        <footerBody>
            <span>
                Copyright &copy; 2020 <strong>FinanC S/A</strong><br/> Todos os direitos reservados<br/>Av. das Cataratas, 1118 – Vila Yolanda, Foz do Iguaçu – PR, 85853-000
            </span>
            <div>
                <span>Política de Privacidade</span> |
                <span>Termos de Uso</span>
            </div>
        </footerBody>
    )
}

export default Footer;