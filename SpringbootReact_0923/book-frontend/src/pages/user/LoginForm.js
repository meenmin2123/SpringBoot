import React from 'react';
import styles from './LoginForm.module.css';
import '../../components/header.css';

const LoginForm = () => {

    return (
            <div className={styles.container}>
                <div className={styles.background}>
                    <div className={styles.shape}></div>
                    <div className={styles.shape}></div>
                </div>
                <form className={styles.form}>
                    <h3>Login Here</h3>

                    <label htmlFor="username" className={styles.label}>Username</label>
                    <input type="text" className={styles.input} placeholder="Email or Phone" id="username" />

                    <label htmlFor="password" className={styles.label}>Password</label>
                    <input type="password" className={styles.input} placeholder="Password" id="password" />

                    <button type="submit" className={styles.button}>Log In</button>
                    <div className={styles.social}>
                        <div className={styles.go}><i className="fab fa-google"></i> Google</div>
                        <div className={styles.fb}><i className="fab fa-facebook"></i> Facebook</div>
                    </div>
                </form>
            </div>
        

    );
}

export default LoginForm;
