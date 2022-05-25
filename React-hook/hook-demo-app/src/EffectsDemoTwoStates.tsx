import { useEffect, useRef, useState } from "react";
import './EffectsDemoTwoStates.css'

function EffectsDemoTwoStates() {
    const [title, setTitle] = useState<string>('Hello');
    const titleRef = useRef<HTMLInputElement>(null);
    const [darkMode, setDarkMode] = useState<boolean>(false);

    useEffect(() => {
        console.log('useEffect');
        document.title = title;
    });

    console.log('render');
    const handleClick = () => {
        if (titleRef.current) {
            setTitle(titleRef.current.value);
        }
    };
    const handleCheckBoxChange = () => {
        console.log('setDarkMode');
        setDarkMode((prev) => !prev);
    }

    return (
        <div className={darkMode ? "view dark-mode" : "view"}>
            <label htmlFor="darkMode">dark mode</label>
            <input
                name="darkMode"
                type="checkbox"
                checked={darkMode}
                onChange={handleCheckBoxChange}
            />
            <input ref={titleRef} />
            <button onClick={handleClick}>change title</button>
        </div>
    );

}

export default EffectsDemoTwoStates;