import styled from 'styled-components';
import Logo from '../../img/logofinance.png'
import {Link} from 'react-router-dom';

const Nav = styled.div `
    width: 100%;
    height: 10vh;
    position: fixed;
    background: #8DB892;
    display: flex;
    justify-content: space-evenly;
    align-items: center;

    img {
        width: 30%;
        display: absolute; 
    }
`;

function Navbar() {
    return(
        <Nav>
            <Link className="link" to="/Home">
                <img className="logofinanc" src={Logo} alt="Logo Financ"/>
            </Link>
        </Nav>
    )
}

export default Navbar;