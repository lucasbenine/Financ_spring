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
        width: 7%;
        height: 50%;
        background:#8DB892; 
    }
`;

function Navbar() {
    return(
        <Nav>
            <Link className="link" to="/Home" style={{textDecoration: 'none', margin: '0', padding: '0'}}>
                <img className="logofinanc" src={Logo} alt="Logo Financ" />
            </Link>
        </Nav>
    )
}

export default Navbar;